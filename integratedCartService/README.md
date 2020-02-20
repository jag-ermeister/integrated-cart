To build integrated-cart-service and run locally in a docker container, run the following:
```
./gradlew build
docker build -f Dockerfile-local -t integrated-cart-service .
docker run -it -p 8080:8080 --rm integrated-cart-service
```

Redis must be running on port 6379.