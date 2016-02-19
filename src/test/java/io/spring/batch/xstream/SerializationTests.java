/*
 * Copyright 2016 the original author or authors.
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
package io.spring.batch.xstream;

import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;

import org.junit.Test;

import org.springframework.batch.core.repository.dao.XStreamExecutionContextStringSerializer;

/**
 * @author Michael Minella
 */
public class SerializationTests {

	private static final String EXAMPLE_EXECUTION_CONTEXT = "{\n" +
			"  \"map\": [{\n" +
			"    \"entry\": [{\n" +
			"      \"string\": [\"batch.taskletType\", “our.job.TaskletType\"]\n" +
			"    }, {\n" +
			"      \"string\": [\"batch.stepType\", \"org.springframework.batch.core.step.tasklet.TaskletStep\"]\n" +
			"    }]\n" +
			"  }]\n" +
			"}";

	@Test
	public void testDeserialization() throws Exception {
		XStreamExecutionContextStringSerializer serializer = new XStreamExecutionContextStringSerializer();
		serializer.afterPropertiesSet();

		serializer.deserialize(new ByteArrayInputStream(EXAMPLE_EXECUTION_CONTEXT.getBytes(StandardCharsets.UTF_8)));
	}
}
