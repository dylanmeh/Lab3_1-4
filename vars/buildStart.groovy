def call() {

sh '''
    stage_time=$(date '+%d/%m/%Y %H:%M:%S')
    echo "Build started at $stage_time"
   '''

}
