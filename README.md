# integrated-cart

To run the Java Consumer contract tests:
`./gradlew test`

To run the JS Consumer contract tests from the repo's root directory:
`npm test --prefix cartJsConsumer`

To deploy the documentation:
```
cd docks
docker build -t docs-image:v1 .
docker run -d -p 80:80 docks-image:v1
```