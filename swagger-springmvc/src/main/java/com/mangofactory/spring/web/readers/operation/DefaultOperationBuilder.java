package com.mangofactory.spring.web.readers.operation;

import com.mangofactory.schema.plugins.DocumentationType;
import com.mangofactory.spring.web.plugins.OperationBuilderPlugin;
import com.mangofactory.spring.web.plugins.OperationContext;
import org.springframework.stereotype.Component;

@Component
public class DefaultOperationBuilder implements OperationBuilderPlugin {
  @Override
  public void apply(OperationContext context) {
    String operationName = context.getHandlerMethod().getMethod().getName();
    context.operationBuilder()
            .method(context.httpMethod())
            .nickname(operationName)
            .notes(operationName)
            .position(context.operationIndex())
            .summary(operationName);
  }

  @Override
  public boolean supports(DocumentationType delimiter) {
    return true;
  }
}