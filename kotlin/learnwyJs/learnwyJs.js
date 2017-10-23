if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'learnwyJs'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'learnwyJs'.");
}
var learnwyJs = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function format(date, template) {
    if (date === void 0)
      date = new Date();
    if (template === void 0)
      template = 'yyyy-MM-dd hh:mm:ss';
    console.log(date, template);
  }
  function learnwyDate() {
    this.year = '';
    this.month = '';
    this.day = '';
    this.hour = '';
    this.minutes = '';
    this.seconds = '';
    this.time = 0;
  }
  learnwyDate.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: 'learnwyDate',
    interfaces: []
  };
  function learnwyDate_init(date, $this) {
    if (date === void 0)
      date = new Date();
    $this = $this || Object.create(learnwyDate.prototype);
    learnwyDate.call($this);
    $this.time = date.getTime();
    return $this;
  }
  function parseDate(date) {
    if (date === void 0)
      date = new Date();
    return learnwyDate_init(date);
  }
  function A() {
  }
  A.prototype.foo = function () {
    println('A:foo');
  };
  A.$metadata$ = {
    kind: Kotlin.Kind.INTERFACE,
    simpleName: 'A',
    interfaces: []
  };
  function B() {
  }
  B.prototype.foo = function () {
    println('B:foo');
  };
  B.prototype.bar = function () {
    println('B:bar');
  };
  B.$metadata$ = {
    kind: Kotlin.Kind.INTERFACE,
    simpleName: 'B',
    interfaces: []
  };
  function C() {
  }
  C.prototype.bar = function () {
    println('C:bar');
  };
  C.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: 'C',
    interfaces: [A]
  };
  function D() {
  }
  D.prototype.foo = function () {
  };
  D.prototype.bar = function () {
  };
  D.$metadata$ = {
    kind: Kotlin.Kind.CLASS,
    simpleName: 'D',
    interfaces: [B, A]
  };
  function main(args) {
    var message = 'Hello JavaScript!';
    (new D()).bar();
    (new D()).foo();
    (new C()).bar();
    (new C()).foo();
    println(message);
  }
  var package$com = _.com || (_.com = {});
  var package$learnwy = package$com.learnwy || (package$com.learnwy = {});
  var package$kotlin = package$learnwy.kotlin || (package$learnwy.kotlin = {});
  var package$date = package$kotlin.date || (package$kotlin.date = {});
  package$date.format_6uwz5k$ = format;
  package$date.learnwyDate_init_qjzqsm$ = learnwyDate_init;
  package$date.learnwyDate = learnwyDate;
  package$date.parseDate_qjzqsm$ = parseDate;
  var package$pratice = package$kotlin.pratice || (package$kotlin.pratice = {});
  package$pratice.A = A;
  package$pratice.B = B;
  package$pratice.C = C;
  package$pratice.D = D;
  _.main_kand9s$ = main;
  C.prototype.foo = A.prototype.foo;
  main([]);
  Kotlin.defineModule('learnwyJs', _);
  return _;
}(typeof learnwyJs === 'undefined' ? {} : learnwyJs, kotlin);

//# sourceMappingURL=learnwyJs.js.map
