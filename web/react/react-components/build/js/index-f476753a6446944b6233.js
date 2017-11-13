webpackJsonp([0,1,2],{

/***/ 105:
/*!********************************************!*\
  !*** ./src/components/content/Content.tsx ***!
  \********************************************/
/*! dynamic exports provided */
/*! all exports used */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

Object.defineProperty(exports, "__esModule", { value: true });
var React = __webpack_require__(/*! react */ 0);
var antd_1 = __webpack_require__(/*! antd */ 66);
__webpack_require__(/*! ./Content.less */ 164);
var AntdContent = antd_1.Layout.Content;

var Content = function (_React$Component) {
    _inherits(Content, _React$Component);

    function Content(props) {
        _classCallCheck(this, Content);

        return _possibleConstructorReturn(this, (Content.__proto__ || Object.getPrototypeOf(Content)).call(this, props));
    }

    _createClass(Content, [{
        key: "render",
        value: function render() {
            return React.createElement(AntdContent, { className: 'learnwy-content' });
        }
    }]);

    return Content;
}(React.Component);

exports.Content = Content;

/***/ }),

/***/ 164:
/*!*********************************************!*\
  !*** ./src/components/content/Content.less ***!
  \*********************************************/
/*! dynamic exports provided */
/*! all exports used */
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ 165:
/*!******************************************!*\
  !*** ./src/components/header/Header.tsx ***!
  \******************************************/
/*! dynamic exports provided */
/*! all exports used */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


var _createClass = function () { function defineProperties(target, props) { for (var i = 0; i < props.length; i++) { var descriptor = props[i]; descriptor.enumerable = descriptor.enumerable || false; descriptor.configurable = true; if ("value" in descriptor) descriptor.writable = true; Object.defineProperty(target, descriptor.key, descriptor); } } return function (Constructor, protoProps, staticProps) { if (protoProps) defineProperties(Constructor.prototype, protoProps); if (staticProps) defineProperties(Constructor, staticProps); return Constructor; }; }();

function _classCallCheck(instance, Constructor) { if (!(instance instanceof Constructor)) { throw new TypeError("Cannot call a class as a function"); } }

function _possibleConstructorReturn(self, call) { if (!self) { throw new ReferenceError("this hasn't been initialised - super() hasn't been called"); } return call && (typeof call === "object" || typeof call === "function") ? call : self; }

function _inherits(subClass, superClass) { if (typeof superClass !== "function" && superClass !== null) { throw new TypeError("Super expression must either be null or a function, not " + typeof superClass); } subClass.prototype = Object.create(superClass && superClass.prototype, { constructor: { value: subClass, enumerable: false, writable: true, configurable: true } }); if (superClass) Object.setPrototypeOf ? Object.setPrototypeOf(subClass, superClass) : subClass.__proto__ = superClass; }

Object.defineProperty(exports, "__esModule", { value: true });
var React = __webpack_require__(/*! react */ 0);
var antd_1 = __webpack_require__(/*! antd */ 66);
__webpack_require__(/*! ./Header.less */ 166);
var AntdHeader = antd_1.Layout.Header;

var Header = function (_React$Component) {
    _inherits(Header, _React$Component);

    function Header(props) {
        _classCallCheck(this, Header);

        return _possibleConstructorReturn(this, (Header.__proto__ || Object.getPrototypeOf(Header)).call(this, props));
    }

    _createClass(Header, [{
        key: "render",
        value: function render() {
            return React.createElement(AntdHeader, { className: 'learnwy-header' });
        }
    }]);

    return Header;
}(React.Component);

exports.Header = Header;

/***/ }),

/***/ 166:
/*!*******************************************!*\
  !*** ./src/components/header/Header.less ***!
  \*******************************************/
/*! dynamic exports provided */
/*! all exports used */
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ 943:
/*!***********************!*\
  !*** ./src/index.tsx ***!
  \***********************/
/*! dynamic exports provided */
/*! all exports used */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", { value: true });
var React = __webpack_require__(/*! react */ 0);
var ReactDom = __webpack_require__(/*! react-dom */ 10);
var antd_1 = __webpack_require__(/*! antd */ 66);
var header_1 = __webpack_require__(/*! ./components/header */ 944);
var content_1 = __webpack_require__(/*! ./components/content */ 945);
__webpack_require__(/*! ./reset.less */ 946);
__webpack_require__(/*! ./index.less */ 947);
var _antd_1$Layout = antd_1.Layout,
    Sider = _antd_1$Layout.Sider,
    Footer = _antd_1$Layout.Footer;

ReactDom.render(React.createElement(
        antd_1.Layout,
        null,
        React.createElement(header_1.Header, { className: 'learnwy-header' }),
        React.createElement(content_1.Content, { className: 'learnwy-content' }),
        React.createElement(Footer, { style: { height: 200 }, className: "learnwy-footer" })
), document.getElementById('app'));

/***/ }),

/***/ 944:
/*!****************************************!*\
  !*** ./src/components/header/index.ts ***!
  \****************************************/
/*! dynamic exports provided */
/*! all exports used */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", { value: true });
var Header_1 = __webpack_require__(/*! ./Header */ 165);
exports.Header = Header_1.Header;

/***/ }),

/***/ 945:
/*!*****************************************!*\
  !*** ./src/components/content/index.ts ***!
  \*****************************************/
/*! dynamic exports provided */
/*! all exports used */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


Object.defineProperty(exports, "__esModule", { value: true });
var Content_1 = __webpack_require__(/*! ./Content */ 105);
exports.Content = Content_1.Content;

/***/ }),

/***/ 946:
/*!************************!*\
  !*** ./src/reset.less ***!
  \************************/
/*! dynamic exports provided */
/*! all exports used */
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ }),

/***/ 947:
/*!************************!*\
  !*** ./src/index.less ***!
  \************************/
/*! dynamic exports provided */
/*! all exports used */
/***/ (function(module, exports) {

// removed by extract-text-webpack-plugin

/***/ })

},[943]);
//# sourceMappingURL=index-f476753a6446944b6233.js.map