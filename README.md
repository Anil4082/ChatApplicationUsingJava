# ChatApplicationUsingJava

![Logo](./clogo.png)

## Overview
The Chat Application is a simple TCP server-client chat application implemented in Java. The server listens for incoming client connections and facilitates real-time communication among connected clients. This application provides a basic chat interface where users can send and receive messages.

## Technologies Used
- **Java**
- **Swing (Java GUI Framework)**
- **Multithreading**
- **Networking (Java ServerSocket and Socket classes)**

## Features
- Designed and implemented a multi-threaded TCP server to handle concurrent client connections.
- Developed a client-side application with a Swing-based GUI for real-time chat functionality.
- Utilized ServerSocket and Socket classes for network communication.
- Implemented message handling and broadcasting to distribute messages among clients.
- Managed user inputs and key events to facilitate smooth message sending and receiving.
- Ensured robust resource management and error handling for application stability.

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
- Sets up the `ServerSocket`.
- Enters an infinite loop to accept client connections and spawns a new thread for each client.
- ## Client

### Overview
The client component connects to the server and enables users to send and receive messages through a console interface. It includes a GUI for displaying messages.

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- An IDE of your choice (e.g., IntelliJ IDEA, Eclipse)

### How to Use
1. Clone the repository.
2. Open the project in your IDE.
3. Run the client's `main` method to start the client application.
4. Enter the server's IP address and port number when prompted.

### Code Overview

#### Initialization
- The client initializes a socket to connect to the server on port `4313`.

#### Message Sending and Receiving
- The client captures user input to send messages to the server. Typing "exit" will end the application.
- A separate thread listens for incoming messages from the server and displays them in the console.

#### GUI Components
- The client uses Swing for the GUI, including a heading, message area, and input field.

#### Main Client Class
- Establishes a connection to the server using a `Socket`.
- Starts a thread for sending messages and another for receiving messages.
- Waits for user inputs to send messages and handles server disconnection.
