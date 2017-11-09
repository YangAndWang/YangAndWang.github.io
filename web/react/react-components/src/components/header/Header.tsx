import * as React from 'react'
import {Layout} from 'antd'

const AntdHeader = Layout.Header

interface HeaderProps {

}

export class Header extends React.Component {
    constructor(props: HeaderProps) {
        super(props)
    }

    render() {
        return <AntdHeader/>
    }
}


