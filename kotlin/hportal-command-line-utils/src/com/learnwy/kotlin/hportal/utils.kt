package com.learnwy.kotlin.hportal

import java.io.File
import java.io.FileOutputStream
import java.io.FileReader
import java.nio.ByteBuffer
import java.nio.channels.FileChannel
import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.Paths

/**
 * date 2017/10/17
 * create by learnwy
 * lis is GPL-3.0
 */

/**
 * abc-xyz-mnt => abcXyzMnt
 */
fun lowerCase2Hump(lowerCase: String): String {
    var ret: StringBuilder = StringBuilder();
    for (m in lowerCase.split("-")) {
        var cA: CharArray = m.toCharArray();
        if (cA.getOrNull(0) != null) {
            cA.set(0, cA.get(0).toUpperCase());
        }
        ret.append(cA);
    }
    if (null != ret.getOrNull(0)) {
        ret.setCharAt(0, ret.get(0).toLowerCase());
    }
    return ret.toString();
}

/**
 * abcXyzMnt => abc-xyz-mnt
 */
fun hump2LowerCase(hump: String): String {
    var ret: StringBuilder = StringBuilder();
    var charIndex: Int = 0;
    var tempIndex: Long = 0;
    var temp = (hump?.split("[A-Z]".toRegex()));
    for ((index, s) in hump.split("[A-Z]".toRegex()).withIndex()) {
        if (index === 0) {
            ret.append(s);
            charIndex += s.length;
        } else {
            ret.append('-').append(hump.get(charIndex).toLowerCase()).append(s);
            charIndex += s.length + 1;
        }
    }
    return ret.toString();
}

var portletTemplateCss = ".templateCss-modal{\n" +
        "    \n" +
        "}";
var portletTemplateJs = "(function () {\n" +
        "\n" +
        "    function loadData(\$component, config, data) {\n" +
        "\n" +
        "    }\n" +
        "\n" +
        "    /**\n" +
        "     * 通过 jQuery的 委托绑定事件\n" +
        "     * @param \$component\n" +
        "     */\n" +
        "    function bindEvent(\$component, config) {\n" +
        "\n" +
        "    }\n" +
        "\n" +
        "    /**\n" +
        "     * \$component 是自己写的\$(模板)转化来的 jQuery 对象\n" +
        "     * config 是一个对象 {displayName}\n" +
        "     * changeObject 是一个记录 改变的 {width,height} 改变为 true\n" +
        "     * @param \$component\n" +
        "     * @param config\n" +
        "     * @param changeObject\n" +
        "     */\n" +
        "    function resize(\$component, config, changeObject) {\n" +
        "\n" +
        "    }\n" +
        "\n" +
        "    function resizeX(\$component, config) {\n" +
        "\n" +
        "    }\n" +
        "\n" +
        "    function resizeY(\$component, config) {\n" +
        "\n" +
        "    }\n" +
        "\n" +
        "    var template = {\n" +
        "        /**\n" +
        "         *\n" +
        "         * @param \$component 模板 转换的 jQuery 对象\n" +
        "         * @param config     组件的配置 {id,name,widthScale,...}\n" +
        "         * @param data       组件所需的数据 现在改由 组件自己获取\n" +
        "         */\n" +
        "        entryJs: function (\$component, config) {\n" +
        "            bindEvent(\$component, config);\n" +
        "            loadData(\$component, config);\n" +
        "        },\n" +
        "        widthScale: 12, //bootstrap 栅栏宽\n" +
        "        displayName: 'template',//组件显示名\n" +
        "        name: 'template', // 组件名\n" +
        "        height: 300,  // 组件默认高度\n" +
        "        width: 300,   // 组件默认宽度\n" +
        "        resize: resize\n" +
        "    };\n" +
        "    HPortal.store.setComponent('template', template);\n" +
        "\n" +
        "    // return news;\n" +
        "})();\n" +
        ""
var portletContentModalTemplateCss = ".templateCss-modal{\n" +
        "    \n" +
        "}";
var portletContentModalTemplateJs = "(function () {\n" +
        "    function init(data) {\n" +
        "\n" +
        "    }\n" +
        "\n" +
        "    function initOnce(data) {\n" +
        "\n" +
        "    }\n" +
        "\n" +
        "    function showModal() {\n" +
        "\n" +
        "    }\n" +
        "\n" +
        "    var templateContentModal = {\n" +
        "        init: init,\n" +
        "        initOnce: initOnce,\n" +
        "        showModal: showModal\n" +
        "    };\n" +
        "\n" +
        "    HPortal.store.setModal('templateContentModal', templateContentModal);\n" +
        "\n" +
        "})();";
var TEMPLATE_HTML = "<div class=\"templateCss\">\n" +
        "\n" +
        "</div>";

fun createIfUnExists(files: Array<File>): Boolean {
    var existOneFile: Boolean = false;
    for (f: File in files) {
        if (!f.exists()) {
            Files.createDirectories(Paths.get(f.parent));
            Files.createFile(Paths.get(f.absolutePath))
        } else {
            existOneFile = true;
        }
    }
    return existOneFile;
}

fun genPortlet(name: String) {
    var template = hump2LowerCase(name);
    var fileName = lowerCase2Hump(template);
    var contentModal = fileName + "ContentModal";
    var contentModalCss = template + hump2LowerCase("ContentModal");
    // portlet
    var css: File = File("resources/webapp/resources/portlet/${fileName}/css/${fileName}.css");
    var js: File = File("resources/webapp/resources/portlet/${fileName}/js/${fileName}.js");
    var html: File = File("resources/webapp/WEB-INF/view/portlet/${fileName}.html");
    // content modal
    var modalJs: File = File("resources/webapp/resources/portlet/${fileName}/js/${contentModal}.js");
    var modalCss: File = File("resources/webapp/resources/portlet/${fileName}/css/${contentModal}.css");
    var modalHtml: File = File("resources/webapp/WEB-INF/view/portlet/modal/${contentModal}.html");
    if (createIfUnExists(arrayOf(css, js, html, modalCss, modalJs, modalHtml))) {
        var cssChannel: FileChannel = FileOutputStream(css).channel;
        cssChannel.write(ByteBuffer.wrap(portletTemplateCss.replace("template", fileName).replace("templateCss", template).toByteArray()));
        cssChannel.force(true);

    } else {
        error("组件${fileName}之前已经存在,请手动删除再生成");
    }
}

fun genModal(name: String) {

}

fun gen(args: Array<String>) {
    if (args.size < 2) {
        println("参数不正确,<type> <name>,type 为portlet 和 modal");
    }
    var type: String = args [0];
    var name: String = args [1];
    when (type) {
        "portlet" -> genPortlet(name);
        "" -> genModal(name);
        else -> error("非法的参数 type");
    };
}