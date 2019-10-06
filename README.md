# reactive-tracking-demo

```
./gradlew bootRun
```
```
 curl -X POST -H "Content-Type: application/json" -d @artillery/data/CreateEventsRequest_01.json http://localhost:8080/
 curl -X POST -H "Content-Type: application/json" -d @artillery/data/CreateEventsRequest_02.json http://localhost:8080/
```

# automated test

```
npm install -g artillery

artillery run artillery/load-test.yml
```