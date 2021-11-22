sh ./gradlew bootJar
cp build/libs/PBZ_lr2-0.0.1-SNAPSHOT.jar docker
cd docker
docker build -t fdm .
docker-compose up
rm docker/PBZ_lr2-0.0.1-SNAPSHOT.jar
