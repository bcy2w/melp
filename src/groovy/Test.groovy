class Test {
    def world

    public void takeTurn() {
        if ( world.introduction ) {
            println "Introduction:\n\t${world.introduction}"
        }
        world.message = "Hello World!"
    }

}
