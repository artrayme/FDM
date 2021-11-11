sh ./gradlew bootJar
cp build/PBZ_lr2-0.0.1-SNAPSHOT.jar docker
cd docker
docker build -t fdm .
docker-compose up

