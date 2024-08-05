# ChatApplication  

## Overview  
The Chat Application is a simple TCP server-client chat application implemented in Java. The server listens for incoming client connections and facilitates real-time communication among connected clients. This application provides a basic chat interface where users can send and receive messages.  

## Server  

### Overview  
The server component establishes a listening socket, accepts incoming client connections, and broadcasts messages to all connected clients.  

### Prerequisites  
- Java Development Kit (JDK) 8 or higher  
- An IDE of your choice (e.g., IntelliJ IDEA, Eclipse)  

### How to Use  
1. Clone the repository.  
2. Open the project in your IDE.  
3. Run the server's `main` method to start the server.  

### Code Overview  

#### Initialization  
- The server initializes a `ServerSocket` to listen for incoming connections on a specified port.  

#### Client Interaction  
- Each client connection is handled in a separate thread, allowing for simultaneous communication.  
- The server reads messages from clients and broadcasts them to all connected clients.  

### Main Server Class  
1. Sets up the `ServerSocket`.  
2. Enters an infinite loop to accept client connections and spawn a new thread for each client.  

---  

## Client  

### Overview  
The client component connects to the server and enables users to send and receive messages through a console interface.  

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
- The client initializes a socket to connect to the server.  

#### Message Sending and Receiving  
- The client captures user input to send messages to the server. Typing "quit" will end the application.  
- A separate thread listens for incoming messages from the server and displays them in the console.  

### Main Client Class  
1. Establishes a connection to the server using a `Socket`.  
2. Starts a thread for sending messages and another for receiving messages.  
3. Waits for user inputs to send messages and handles server disconnection.  

---  

## Contributing  
Contributions are welcome! If you have any suggestions or improvements, feel free to submit a pull request.  

## License  
This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for more details.  

## Acknowledgements  
- Java SDK documentation for guidance on socket programming.
