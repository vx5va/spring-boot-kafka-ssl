# Keystore and Truststore

## Keystore
The keystore password is `kafka1`

The keystore is used to hold a certificate that can be used to identify/authenticate this server as well as for signing

### Generating the keystore
`keytool -keystore kafka.server.keystore.jks -keyalg RSA -genkey -alias kafka-server`

### Exporting the public cert from the keystore into a file
`keytool -export -keystore kafka.server.keystore.jks -alias kafka-server -file kafka-server-public-cert.crt`

### Listing the contents of keystore
`keytool -list -keystore kafka.server.keystore.jks`

## Truststore

The truststore password is `kafka1`

The truststore is used to hold certificates (or Certificate Authority certificates) of servers we want to trust when connecting to them

### Generating a new truststore and adding a public cert (that you want to trust into it) in one command
`keytool -import -file app-public-cert.crt -alias vics-app -keystore kafka.server.truststore.jks`


