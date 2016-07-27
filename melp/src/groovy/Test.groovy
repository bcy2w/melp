class Test {
    def world

    public void takeTurn() {
        println "${world.introduction.description}:\n\n${world.introduction.value}\n"
        println "${world.instructions.description}:\n\n${world.instructions.value}\n"

        println "Input Variables:\n\t${world.inVariableNames}"
        println "Output Variables:\n\t${world.outVariableNames}"

        world.message = "Hello World!"
    }
}
