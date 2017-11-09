package search;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

/**
 *
 * @author nilstes
 */
public class SearchEngineTest {

    private PageReader pageReader;
    
    public SearchEngineTest() {
    }

    @Before
    public void setUp() {
        pageReader = mock(PageReader.class);

        when(pageReader.readPage("https://test.no")).thenReturn(new String[]{"Test", "er", "bra"});
        when(pageReader.readPage("https://example.com/test")).thenReturn(new String[]{"Dette", "er", "en", "test", "er", "det"});
        when(pageReader.readPage("https://no.wikipedia.org/wiki/Programvaretesting")).thenReturn(new String[]{"Test", "Test", "lurt", "å", "teste"});
    }

    @Test
    public void searchForWordOnWebPageTest() {
        SearchEngine searchEngine = new SearchEngine(pageReader);

        searchEngine.indexPage("https://test.no");
        searchEngine.indexPage("https://example.com/test");
        searchEngine.indexPage("https://no.wikipedia.org/wiki/Programvaretesting");

        List<String> expected = Arrays.asList("https://no.wikipedia.org/wiki/Programvaretesting", "https://test.no");
        assertEquals(expected, searchEngine.search("Test"));

        expected = Arrays.asList("https://example.com/test", "https://test.no");
        assertEquals(expected, searchEngine.search("er"));
    }

    @Test
    public void searchForWordWhichIsNotIndexedTest() {
        SearchEngine searchEngine = new SearchEngine(pageReader);

        searchEngine.indexPage("https://test.no");
        searchEngine.indexPage("https://example.com/test");
        searchEngine.indexPage("https://no.wikipedia.org/wiki/Programvaretesting");

        List<String> expected = Arrays.asList();
        assertEquals(expected, searchEngine.search("Finnesikke"));
    }
}
