def call(def config=[:]) {

sh '''
    dt=$(date '+%d/%m/%Y %H:%M:%S')
    echo "Build compeleted at $dt"
   '''

}
