javac --release 8 -cp . server/*.java
start rmiregistry
java -cp .  server/Server