import React from 'react';
import PureRenderMixin from 'react-addons-pure-render-mixin';
import _ from 'underscore';
import references from './bib';

var Bibl = React.createClass({
  mixins: [PureRenderMixin],

  getDefaultProps: function () {
    return {};
  },

  render: function () {


    return <section id="bibliography">
      <h2>References</h2>
      <ol id="reference-list">
        {_.map(references, function (citation, i) {
          var nameStr = citation.author.full;
          if (!citation.author.full) {
            nameStr = citation.author.lastName + (citation.author.firstName ? ", " + citation.author.firstName : "");
          }
          if (nameStr) {
            nameStr = <span className="ref-author">{nameStr}</span>
          }
          const publication = citation.journal ?
            <span><span className="ref-journal">{citation.journal}</span>.</span>
            : "";

          return <li itemProp="citation"
                     itemScope={true}
                     itemType="http://schema.org/CreativeWork"
                     key={i}
                     id={citation.id.toString()}
                     className="ref">
            {nameStr} (<time dateTime={citation.year} className="ref-year">{citation.year}</time>). <cite>
            <a href={citation.href}><span itemProp="name">{citation.title}</span></a>
          </cite>. {publication}
          </li>;
        })}
      </ol>
    </section>;
  }
});


export default Bibl;
