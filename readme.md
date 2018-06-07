# gRPC Java Auth examples

echo.proto is from [grpc-swift](https://github.com/grpc/grpc-swift/blob/master/Sources/Examples/Echo/echo.proto)

generate certs using `./soseedygrpc/openssl/key.sh`

- Install [JetBrains Toolbox](https://www.jetbrains.com/toolbox/)
- Install `IntelliJ IDEA Community`
- Open `build.gradle`
- Run the server and clients from the IDE
  - `mutual_auth/MutualAuthServerTls.kt`
  - `mutual_auth/MutualAuthClientTls.kt`
  - `regular_tls/ServerTls.kt`
  - `regular_tls/ClientTls.kt`
  - `token_auth/TokenAuthServer.kt`
  - `token_auth/TokenAuthClient.kt`
  - `plaintext/ClientPlain.kt`
  - `plaintext/ServerPlain.kt`

<img src="img/1.png" width="50%" />
<img src="img/2.png" width="50%" />
<img src="img/3.png" width="50%" />

## failed to bind

- `killall -9 java`

## connect refused

Update `/etc/hosts` with `127.0.0.1	example.com`
The cert generation script is tied to the example.com hostname.
