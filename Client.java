import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
// import java.io.*;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
// import java.awt.event.KeyAdapter;

public class Client extends JFrame {
    Socket socket;
 BufferedReader br;
    PrintWriter out;
       

//declare component
private JLabel heading=new JLabel("Client Area");
private JTextArea messageArea=new JTextArea();
private JTextField messageInput=new JTextField();
private Font font=new Font("Roboto",Font.PLAIN,20);



    //constructor
    public Client(){
        try {
            System.out.println("sending request to server");
            socket=new Socket("127.0.0.1",4313);
            System.out.println("connection done.");
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());
createGUI();
handleEvents();
        startReading();
           // startWriting();
        } catch (Exception e) {
            
        }
    }

/**
 * 
 */

 private void handleEvents() {
    messageInput.addKeyListener(new KeyListener() {
        @Override
        public void keyReleased(KeyEvent e) {
            if (e.getKeyCode() == 10) {
                String contentToSend = messageInput.getText();
                messageArea.append("Me: " + contentToSend + "\n");
                out.println(contentToSend);
                out.flush();
                messageInput.setText("");
                messageInput.requestFocus();
            }
        }

        @Override
        public void keyTyped(KeyEvent e) {
            // No action needed for keyTyped
        }

        @Override
        public void keyPressed(KeyEvent e) {
            // No action needed for keyPressed
        }
    });
}

private void createGUI()
{
   // GUi code
   this.setTitle("Client Messge");
   this.setSize(600,750);
   this.setLocationRelativeTo(null);
   this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
   //coding componet
   heading.setFont(font);
   messageArea.setFont(font);
   messageInput.setFont(font);


   heading.setIcon(new ImageIcon("clogo.png"));
   heading.setHorizontalTextPosition(SwingConstants.CENTER);
   heading.setVerticalTextPosition(SwingConstants.BOTTOM);
   heading.setHorizontalAlignment(SwingConstants.CENTER);
   
   heading.setBorder(BorderFactory.createEmptyBorder(20,20,20,20));
messageArea.setEditable(false);
   messageInput.setHorizontalAlignment(SwingConstants.CENTER);



//frame ka layout set karenge
this.setLayout(new BorderLayout());
//adding thecomponent frame
this.add(heading,BorderLayout.NORTH);
JScrollPane jScrollPane=new JScrollPane(messageArea);
this.add(jScrollPane,BorderLayout.CENTER);
this.add(messageInput,BorderLayout.SOUTH);


   this.setVisible(true);
}




    //reading method
    public void startReading() {
        // Thread read kar ke deta rahega
        Runnable r1 = () -> {
            System.out.println("Reader started...");
            try {
                while (true) {
                    String msg = br.readLine();
                    if ( msg.equals("exit")) {
                        System.out.println("Server terminated the chat");
                       JOptionPane.showMessageDialog(this,"Server Terminated the chat");
                       messageInput.setEnabled(false);
                       socket.close();
                        break;
                    }
                  //  System.out.println("Server: " + msg);
                  messageArea.append("server:  " +" " +msg+"\n");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(r1).start();
    }



    //writing method
    public void startWriting() {
        // Thread - data user lega and then send karega client tak
        Runnable r2 = () -> {
            System.out.println("Writer started...");
            try {
                BufferedReader br1 = new BufferedReader(new InputStreamReader(System.in));
                while (true && !socket.isClosed()) {
                    String content = br1.readLine();
                    out.println(content);
                    out.flush();
                    if (content.equals("exit")) {
                        socket.close();
                        break;
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        };

        new Thread(r2).start();
    }
    public static void main(String[] args) {
        System.out.println("this is client...");
        new Client();
    }
}
