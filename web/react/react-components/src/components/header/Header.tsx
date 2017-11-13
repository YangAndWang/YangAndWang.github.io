import * as React from 'react'
import {Layout} from 'antd'
import './Header.less'

const AntdHeader = Layout.Header

interface HeaderProps {
    className: string
}

export class Header extends React.Component<HeaderProps> {
    constructor(props: HeaderProps) {
        super(props)
    }

    render() {
        return <AntdHeader className={'learnwy-header'}/>
    }
}
