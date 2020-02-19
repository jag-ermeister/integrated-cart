To build integrated-cart-service and run locally in a docker container, run the following:
```
./gradlew build
docker build -t integrated-cart-service .
docker run -it --rm integrated-cart-service
```

Redis must be running on port 6379.