import React from 'react';
import {Button, Table} from "antd";

const dataSource = [{
    id: 'nju-b1',
    name: 'book1',
    author: 'auth1',
    price: '32',
},{
    id: 'nju-b2',
    name: 'book2',
    author: 'auth1',
    price: '32',
},{
    id: 'nju-b3',
    name: 'book3',
    author: 'auth2',
    price: '32',
},{
    id: 'nju-b4',
    name: 'book4',
    author: 'auth2',
    price: '32',
}
];

export class BookListComponent extends React.Component {

    state = {
        selectedRowKeys: [],
    };
    onSelectChange = (selectedRowKeys) => {
        console.log('selectedRowKeys changed: ', selectedRowKeys);
        this.setState({ selectedRowKeys });
    };

    static defaultProps = {
        dataSource: dataSource,
    };

    columns = [{
        title: '书号',
        dataIndex: 'id',
    },{
        title: '书名',
        dataIndex: 'name',
    }, {
        title: '作者',
        dataIndex: 'author',
    }, {
        title: '价格',
        dataIndex: 'price',
    }, {
        title: '操作',
        key: 'operation',
        render: (text, record) => {
            return (
                <Button type="primary" onClick={() => {
                    console.log('查看', record);
                    const {onShowDetail} = this.props;
                    onShowDetail(record.id, record.name);
                }}>
                    查看详情
                </Button>
            )
        }
    }
    ];

    render() {
        const {addBook} = this.props;
        const { selectedRowKeys } = this.state;
        const rowSelection = {
            selectedRowKeys,
            onChange: this.onSelectChange,
        };
        const hasSelected = selectedRowKeys.length > 0;
        return (
            <div>
                <div style={{ marginBottom: 16 }}>
                    <Button type="primary" onClick={addBook} style={{ marginLeft: 8}}>
                        新增图书
                    </Button>
                    <Button type="primary" disabled={!hasSelected} style={{ marginLeft: 8}}>
                        加入购物车
                    </Button>
                    <Button type="danger" disabled={!hasSelected} style={{ marginLeft: 8}}>
                        删除商品项
                    </Button>
                    <span style={{ marginLeft: 8 }}>
                        {hasSelected ? `已选择 ${selectedRowKeys.length} 项` : ''}
                    </span>
                </div>
                <Table rowSelection={rowSelection} dataSource={this.props.dataSource} columns={this.columns} rowKey={'id'} />
            </div>
        )
    }
}