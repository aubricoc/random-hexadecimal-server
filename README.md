# Random Hexadecimal Server

HTTP Server to generate random hexadecimal numbers of a fixed 32 characters length.

Execute jar as:

```bash
java –jar httpserver.jar –port n
```

Where:
- **-port n** : Port where the server will listen

Any request to the server will return:
- Status Code: 200
- Content Type: text/plain
- Body: Hexadecimal number
