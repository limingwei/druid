/*
 * Copyright 1999-2101 Alibaba Group Holding Ltd.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.alibaba.druid.bvt.sql.sqlserver;

import junit.framework.TestCase;

import org.junit.Assert;

import com.alibaba.druid.sql.ast.SQLStatement;
import com.alibaba.druid.sql.dialect.sqlserver.parser.SQLServerStatementParser;
import com.alibaba.druid.sql.test.TestUtils;

public class SQLServerSelectTest16 extends TestCase {

    public void test_simple() throws Exception {
        String sql = "select GEN_VAL " + //
                     "from ID_GENERATOR with (updlock, rowlock) " + //
                     "where GEN_NAME = 'T_USERS'"; //

        String expect = "SELECT GEN_VAL" + //
                        "\nFROM ID_GENERATOR WITH (updlock, rowlock)" + //
                        "\nWHERE GEN_NAME = 'T_USERS'";

        SQLServerStatementParser parser = new SQLServerStatementParser(sql);
        SQLStatement stmt = parser.parseStatementList().get(0);

        String text = TestUtils.outputSqlServer(stmt);

        Assert.assertEquals(expect, text);

//        System.out.println(text);
    }
}
