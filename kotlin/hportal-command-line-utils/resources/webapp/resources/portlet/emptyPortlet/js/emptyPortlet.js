(function () {

    function loadData($component, config, data) {

    }

    /**
     * 通过 jQuery的 委托绑定事件
     * @param $component
     */
    function bindEvent($component, config) {

    }

    /**
     * $component 是自己写的$(模板)转化来的 jQuery 对象
     * config 是一个对象 {displayName}
     * changeObject 是一个记录 改变的 {width,height} 改变为 true
     * @param $component
     * @param config
     * @param changeObject
     */
    function resize($component, config, changeObject) {

    }

    function resizeX($component, config) {

    }

    function resizeY($component, config) {

    }

    var emptyPortlet = {
        /**
         *
         * @param $component 模板 转换的 jQuery 对象
         * @param config     组件的配置 {id,name,widthScale,...}
         * @param data       组件所需的数据 现在改由 组件自己获取
         */
        entryJs: function ($component, config) {
            bindEvent($component, config);
            loadData($component, config);
        },
        widthScale: 12, //bootstrap 栅栏宽
        displayName: 'emptyPortlet',//组件显示名
        name: 'emptyPortlet', // 组件名
        height: 300,  // 组件默认高度
        width: 300,   // 组件默认宽度
        resize: resize
    };
    HPortal.store.setComponent('emptyPortlet', emptyPortlet);

    // return news;
})();
