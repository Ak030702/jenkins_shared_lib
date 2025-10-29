def call(){
    withCredentials([usernamePassword(credentialsId: "dockerhubsc", usernameVariable: "usernameDH", passwordVariable: "passwordDH")])
  {
    echo "Pushing the images"
    sh "docker login -u ${env.usernameDH} -p ${env.passwordDH}"
    echo "Tagging the images"
    sh "docker tag frontend ${env.usernameDH}/frontend:latest"
    sh "docker tag backend ${env.usernameDH}/backend:latest"
    echo "Pushing images to Docker Hub"
    sh "docker push ${env.usernameDH}/frontend:latest"
    sh "docker push ${env.usernameDH}/backend:latest"
}
