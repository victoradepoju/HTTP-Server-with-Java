package com.victor.http;

import com.victor.http.exception.BadHttpVersionException;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class HttpVersionTest {

    @Test
    void getBestCompatibleVersionExactMatch() {
        HttpVersion version = null;
        try {
            version = HttpVersion.getBestCompatibleVersion("HTTP/1.1");
        } catch (BadHttpVersionException e) {
            e.printStackTrace();
            fail();
        }
        assertNotNull(version);
        assertEquals(HttpVersion.HTTP_1_1, version);
    }

    @Test
    void getBestCompatibleVersionBadFormat() {
        HttpVersion version = null;
        try {
            version = HttpVersion.getBestCompatibleVersion("Http/1.1");
            fail();
        } catch (BadHttpVersionException e) {
        }
    }

    @Test
    void getBestCompatibleVersionHigherVersion() {
        HttpVersion version = null;
        try {
            version = HttpVersion.getBestCompatibleVersion("HTTP/1.2");
            assertNotNull(version);
            assertEquals(HttpVersion.HTTP_1_1, version);
        } catch (BadHttpVersionException e) {
            fail();
        }
    }
}
