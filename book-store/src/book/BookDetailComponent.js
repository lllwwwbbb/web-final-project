import React from 'react';

export class BookDetailComponent extends React.Component {
    render() {
        const {id} = this.props;
        return (
            <div>
                Book Detail for {id}
            </div>
        )
    }
}