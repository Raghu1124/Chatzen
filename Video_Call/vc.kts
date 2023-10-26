import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.twilio.video.*
import kotlinx.android.synthetic.main.activity_video_call.*

class VideoCallActivity : AppCompatActivity() {
    private lateinit var videoView: VideoView
    private lateinit var room: Room

    private val accessToken = "YOUR_ACCESS_TOKEN" // Replace with your Twilio access token
    private val roomName = "myRoom"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_call)

        videoView = findViewById(R.id.videoView)

        // Initialize Twilio Video
        Twilio.init(this)

        // Connect to a room
        val connectOptions = ConnectOptions.Builder(accessToken)
            .roomName(roomName)
            .build()

        room = Video.connect(this, connectOptions, object : Room.Listener {
            override fun onConnected(room: Room) {
                // Local participant has joined the room
            }

            override fun onConnectFailure(room: Room, twilioException: TwilioException) {
                // Handle connection failure
            }

            override fun onDisconnected(room: Room, twilioException: TwilioException?) {
                // Handle disconnection
            }

            override fun onParticipantConnected(room: Room, participant: RemoteParticipant) {
                // Participant has joined the room
                participant.videoTracks[0]?.addRenderer(videoView)
            }

            override fun onParticipantDisconnected(room: Room, participant: RemoteParticipant) {
                // Participant has left the room
            }
        })
    }

    override fun onDestroy() {
        room.disconnect()
        super.onDestroy()
    }
}
