./gradlew clean jar
VERSION=$(git rev-parse --short HEAD)
echo "Tagging image with version:$VERSION"
docker build -t my-app:$VERSION .