import React  from 'react'
// import Router from 'react-router'
import chapters from '../../../chapters'
// let Link = Router.Link;
import {getHandler} from '../../Routes.jsx'
import getSectionComponent from '../getSectionComponent'

class ToC extends React.Component {
    static getSubSections(chapter, urlSection, depth, singlePage) {
        if (chapter.getSections && chapter.getSections()) {
            // console.log(chapter.getSections());
            // itemProp={"pageStart":''}
            return <ol>
                {chapter.getSections().inOrder.map(section => {
                    //console.log(JSON.stringify(section));
                    if (!!section) return <li
                        key={section.id}
                        itemScope={true}
                        itemProp="hasPart"
                        itemType="https://schema.org/CreativeWork">
                                <span className="row">
                                    <a hrefLang="en" itemProp="url" href={urlSection+"#"+section.id}>
                                        <span itemProp="name">{section.title}</span>
                                    </a>
                                    {singlePage ? <span className="nr">{section.page}</span> : ''}
                                    </span>
                        {ToC.getSubSections(getSectionComponent(section.id), urlSection, depth + 1, singlePage)}
                    </li>;
                    else throw Error("Null section found in " + JSON.stringify(chapter.getSections()
                        ))
                })}
            </ol>
        } else {
            return "";
        }
    }

    render() {
        let relativeToRoot = this.props.path.match(/\//g).slice(1).map(_ => "../").join("");

        const path = this.props.path;


        var props = this.props;
        return <nav className={'chapter toc'}>
            <ol className={this.props.singlePage?"leaders":""}>
                {this.props.showHome ? <a hrefLang="en" href={relativeToRoot}>Home</a> : ""}
                {
                    chapters.inOrder.map((chapter) => {
                            let urlSection;

                            if (!this.props.singlePage)  urlSection = relativeToRoot + chapter.route.replace('/', '');
                            else  urlSection = "#" + chapter.id;

                        return <li itemProp="hasPart"
                                   itemScope={true}
                                   itemType="https://schema.org/Chapter"
                                   key={chapter.route}>
                                <span className="row">
                                <span >
                                {path == chapter.route
                                    ? <strong itemProp="name">{chapter.title}</strong>
                                    : <a hrefLang="en" itemProp="mainEntityOfPage url" href={urlSection}
                                         className='nav-link'><span itemProp="name">{chapter.title}</span></a>}
                                    </span>
                                    {this.props.singlePage ?
                                        <span itemProp="pageStart" className="nr">{chapter.page}</span> : ''}
                                    </span>
                                {ToC.getSubSections(getHandler(chapter.route), props.singlePage ? '' : urlSection, 1, this.props.singlePage)}
                            </li>
                        }
                    )
                }
            </ol>
        </nav>;
    }

}
ToC.propTypes = {
    path: React.PropTypes.string.isRequired
};
export default ToC;