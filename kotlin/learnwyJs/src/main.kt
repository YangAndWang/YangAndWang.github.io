import com.learnwy.kotlin.annotation.Type

@Type("class")
class Main {
    @Type("property")
    var m: String = "m"
            // set(value) {
            // this.m = value;
            // }
        get() = this.m
    var s: String
        get() {
            return s;
        }
        set(value) {};

    @Type("constructor") constructor(@Type("param") args: Array<String>) {
        main(args);
    }

    @Type("function")
    fun main(@Type("argument") args: Array<String>) {
        console.log(Main::class, args);
    }
}

@Type("function")
fun main(args: Array<String>) {
    Main(args);
}