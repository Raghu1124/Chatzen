package com.example.chatzen20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ChatActivity : AppCompatActivity() {

    private lateinit var chatRecyclerView: RecyclerView
    private lateinit var messageBox: EditText
    private lateinit var sendButton: ImageView
    private lateinit var messageAdapter: MessageAdapter
    private lateinit var mDbRef: DatabaseReference
    private var messageList= ArrayList<Message>()     // isme dekhna h agar koi error hua to

    var receiverRoom: String?= null
    var senderRoom: String?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val name= intent.getStringExtra("name")
        val receiverUid= intent.getStringExtra("uid")

        val senderUid= FirebaseAuth.getInstance().currentUser?.uid
        mDbRef= FirebaseDatabase.getInstance().getReference()

        senderRoom= receiverUid + senderUid
        receiverRoom= senderUid + receiverUid

        supportActionBar?.title= name

        chatRecyclerView= findViewById(R.id.chatRecyclerView)
        messageBox= findViewById(R.id.messageBox)
        sendButton= findViewById(R.id.sendButton)
        messageList= ArrayList()
        messageAdapter= MessageAdapter(this, messageList)

        chatRecyclerView.layoutManager= LinearLayoutManager(this)
        chatRecyclerView.adapter= messageAdapter

//        logic for adding data to recycler view
        mDbRef.child("chats").child(senderRoom!!).child("messages")
            .addValueEventListener(object: ValueEventListener{
                override fun onDataChange(snapshot: DataSnapshot) {

                    messageList.clear()

                    for(postsnapshot in snapshot.children){

                        val message= postsnapshot.getValue(Message::class.java)
                        messageList.add(message!!)
                    }
                    messageAdapter.notifyDataSetChanged()
                }

                override fun onCancelled(error: DatabaseError) {

                }

            })

//      adding the message to the database
        sendButton.setOnClickListener {
            val message= messageBox.text.toString()
            val messageObject= Message(message, senderUid)

//          create node of chats
//          updating the sender room
            mDbRef.child("chats").child(senderRoom!!).child("messages").push()
                .setValue(messageObject).addOnSuccessListener {
//                  updating receiver room
                    mDbRef.child("chats").child(receiverRoom!!).child("messages").push()
                        .setValue(messageObject)
                }
            messageBox.setText("")

        }
    }
}