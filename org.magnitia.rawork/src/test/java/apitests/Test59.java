package apitests;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sun.codemodel.JCodeModel;
import org.jsonschema2pojo.DefaultGenerationConfig;
import org.jsonschema2pojo.GenerationConfig;
import org.jsonschema2pojo.Jackson2Annotator;
import org.jsonschema2pojo.SchemaGenerator;
import org.jsonschema2pojo.SchemaMapper;
import org.jsonschema2pojo.SchemaStore;
import org.jsonschema2pojo.SourceType;
import org.jsonschema2pojo.rules.RuleFactory;

import java.io.File;
import java.io.IOException;

public class Test59
{
	public static void main(String[] args)
	{
		String jsonFilePath="src\\test\\resources\\jsonpayload.json";
        String packageName="com.example.pojo";
        String outputDirectory="target\\mypojos";
        String mainclassname="MyMainPOJO";
        ObjectMapper objectMapper=new ObjectMapper();
        File f=new File(jsonFilePath);
        try 
        {
            JsonNode jsonSchema=objectMapper.readTree(f);
            GenerationConfig config=new DefaultGenerationConfig() 
            {
                @Override
                public boolean isGenerateBuilders() {
                    return true; 
                }
                
                @Override
                public SourceType getSourceType() {
                    return SourceType.JSON;
                }
            };
            SchemaMapper schemaMapper = new SchemaMapper(new RuleFactory(config, new Jackson2Annotator(config), new SchemaStore()), new SchemaGenerator());
            JCodeModel codeModel = new JCodeModel();
            schemaMapper.generate(codeModel,mainclassname,packageName, jsonSchema.toPrettyString());
            codeModel.build(new File(outputDirectory));
        } 
        catch (IOException e) 
        {
            e.printStackTrace();
        }
    }
}
