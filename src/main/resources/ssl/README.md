# Keystore and Truststore

## Keystore
The keystore password is `viciscool`

The keystore is used to hold a certificate that can be used to identify/authenticate this application as well as for signing

Command to generate the keystore
`keytool -keystore app.keystore.jks -keyalg RSA -genkey -alias vics-app`

Command to extract the public cert from the keystore
`keytool -export -keystore app.keystore.jks -alias vics-app -file app-public-cert.crt`

### Listing the contents of keystore
`keytool -list -keystore app.keystore.jks`

## Truststore

The truststore password is `kafka1`

The truststore is used to hold certificates (or Certificate Authority certificates) of servers we want to trust when connecting to them

### Generating a new truststore and adding a public cert (that you want to trust into it) in one command
`keytool -import -file kafka-server-public-cert.crt -alias kafka-server -keystore app.truststore.jks`


