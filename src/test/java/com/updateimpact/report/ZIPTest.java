package com.updateimpact.report;

import com.pholser.junit.quickcheck.ForAll;
import org.junit.contrib.theories.Theories;
import org.junit.contrib.theories.Theory;
import org.junit.runner.RunWith;

import java.io.IOException;

import static org.junit.Assert.*;

@RunWith(Theories.class)
public class ZIPTest {
    @Theory
    public void compressDecompress(@ForAll String s) throws IOException {
        assertEquals(s, ZIP.decompress(ZIP.compress(s)));
    }
}