def call(String frontend_path,String backend_path){
  echo "Building Docker Container"
  sh """docker build -t backend ./${frontend_path}"""
  sh """docker build -t frontend ./${backend_path}"""
}
