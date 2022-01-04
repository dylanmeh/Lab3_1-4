def call(def config=[:]) {

sh '''
    stage_time=$(date '+%d/%m/%Y %H:%M:%S')
    echo "Build compeleted at $stage_time"
   '''

}
