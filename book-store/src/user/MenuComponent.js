import React from 'react';
import {Button, Dropdown, Icon, Menu} from "antd";
import './MenuComponent.css'
const MenuItem = Menu.Item;

export class MenuComponent extends React.Component {

    state = {
        hasLogin: false,
    };

    menu = () => {
        const {onLogout, onShowCart} = this.props;
        return (
            <Menu>
                <MenuItem>
                    <a onClick={onShowCart}>Shopping Cart</a>
                </MenuItem>
                <MenuItem>
                    <a onClick={onLogout}>Logout</a>
                </MenuItem>
            </Menu>
        );
    };

    render() {
        const {userName} = this.props;
        return (
            <div className="user-menu">
                <Dropdown style={{maxHeight: '30px'}}
                    overlay={this.menu()}
                >
                    <div>
                        {userName}
                        <Icon type="down"/>
                    </div>
                </Dropdown>
            </div>
        )
    }
}