import com.squareup.okhttp.HttpUrl;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;
import generated.OpenRechtspraak;
import nl.rechtspraak.schema.rechtspraak_1.Para;
import nl.rechtspraak.schema.rechtspraak_1.TRechtspraakMarkup;
import org.junit.Test;
import org.leibnizcenter.rechtspraak.DocumentRequest;
import org.leibnizcenter.rechtspraak.SearchRequest;
import org.w3._1999._02._22_rdf_syntax_ns_.Description;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPathExpressionException;
import java.io.IOException;
import java.net.URI;
import java.text.ParseException;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Test the JSON-LD output of Rechtspraak.nl XML documents
 * <p>
 * Created by maarten on 31-7-15.
 */
public class ToJsonTest {

    @Test
    public void testDoc() {
        String url = "http://rechtspraak.cloudant.com/ecli/ECLI:NL:GHSHE:2014:1641/data.xml";

        OkHttpClient client = new OkHttpClient();
        Request req = new Request.Builder().url(HttpUrl.get(URI.create(url))).build();
        try {
            Response res = client.newCall(req).execute();
            JAXBContext context = JAXBContext.newInstance(
                    OpenRechtspraak.class,
                    org.purl.dc.terms.ObjectFactory.class,
                    nl.rechtspraak.psi.ObjectFactory.class,
                    org.w3._1999._02._22_rdf_syntax_ns_.ObjectFactory.class,
                    generated.ObjectFactory.class
            );
            Unmarshaller um = context.createUnmarshaller();
            OpenRechtspraak doc = (OpenRechtspraak) um.unmarshal(res.body().byteStream());



        } catch (JAXBException | IOException e) {
            throw new Error(e);
        }
    }

    private int assertAllRechtspraakMarkup(List<Object> content, int i) {
        i++;
        for (Object o : content) {
            //System.out.println(o.getClass());
            if (o instanceof TRechtspraakMarkup) {
                TRechtspraakMarkup markup = (TRechtspraakMarkup) o;
                i += assertAllRechtspraakMarkup(markup.getContent(), 0);
                if(markup instanceof Para){
                    Para p = (Para) markup;
                    //System.out.println(p.getContent());
                }
//            }else if(o instanceof String){
//                System.out.println(o);
            }
        }
        return i;
    }

    public void testList() {
        try {
            List<SearchRequest.JudgmentMetadata> list = (new SearchRequest.Builder())
                    .modified(
                            SearchRequest.Builder.DATE_FORMAT.parse("2014-02-03"),
                            SearchRequest.Builder.DATE_FORMAT.parse("2014-02-04")
                    )
                    .date(
                            SearchRequest.Builder.DATE_FORMAT.parse("2014-02-03"),
                            SearchRequest.Builder.DATE_FORMAT.parse("2014-02-04")
                    ).build().execute();
            System.out.println(list);

            new DocumentRequest(list.get(0).id).execute();
        } catch (IOException | ParserConfigurationException | SAXException | ParseException | XPathExpressionException e) {
            throw new Error(e);
        }
    }

}