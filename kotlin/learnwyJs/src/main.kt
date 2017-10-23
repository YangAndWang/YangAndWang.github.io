import com.learnwy.kotlin.annotation.Type

@Type("class")
class Main {
    @Type("property")
    var m: String = "m";

    @Type("contructor") constructor(@Type("param") args: Array<String>) {
        main(args);
    }

    @Type("function")
    fun main(@Type("argrument") args: Array<String>) {
        console.log(Main::class);
    }
}

@Type("function")
fun main(args: Array<String>) {
    var m: Main = Main(args);
}