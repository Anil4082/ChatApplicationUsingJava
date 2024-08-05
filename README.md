# ChatApplication

![Logo](./clogo.png)

## Overview
The Chat Application is a simple TCP server-client chat application implemented in Java. The server listens for incoming client connections and facilitates real-time communication among connected clients. This application provides a basic chat interface where users can send and receive messages.

## Server

### Overview
The server component establishes a listening socket, accepts incoming client connections, and broadcasts messages to all connected clients. It includes a GUI for displaying messages.

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- An IDE of your choice (e.g., IntelliJ IDEA, Eclipse)

### How to Use
1. Clone the repository.
2. Open the project in your IDE.
3. Run the server's `main` method to start the server.

### Code Overview

#### Initialization
- The server initializes a `ServerSocket` to listen for incoming connections on port `4313`.

#### Client Interaction
- Each client connection is handled in a separate thread, allowing for simultaneous communication.
- The server reads messages from clients and broadcasts them to all connected clients.

#### GUI Components
- The server uses Swing for the GUI, including a heading, message area, and input field.

#### Main Server Class
1. Sets up the `ServerSocket`.
2. Enters an infinite loop to accept client connections and spawns a new thread for each client.

### Server Code Example
```java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Server extends JFrame {
    ServerSocket server;
    Socket socket;
    BufferedReader br;
    PrintWriter out;

    // GUI components
    private JLabel heading = new JLabel("Server Area");
    private JTextArea messageArea = new JTextArea();
    private JTextField messageInput = new JTextField();
    private Font font = new Font("Roboto", Font.PLAIN, 20);

    // Constructor
    public Server() {
        try {
            server = new ServerSocket(4313);
            System.out.println("Server is ready to accept connection");
            System.out.println("Waiting...");
            socket = server.accept();
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream());

            createGUI();
            handleEvents();

            startReading();
            startWriting();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void createGUI() {
        this.setTitle("Server Messenger");
        this.setSize(600, 750);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        heading.setFont(font);
        messageArea.setFont(font);
