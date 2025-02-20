webpackJsonp([1],{

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

/***/ })

},[165]);
//# sourceMappingURL=header-f476753a6446944b6233.js.map