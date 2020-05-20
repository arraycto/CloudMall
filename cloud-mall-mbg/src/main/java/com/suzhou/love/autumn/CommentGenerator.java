package com.suzhou.love.autumn;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * @ClassName: CommentGenerator
 * @Description: 自定义注释生成器
 * @Author: chendq
 * @Date: 2020/5/20 14:33
 * @Version: 1.0
 **/
public class CommentGenerator extends DefaultCommentGenerator {

    private boolean addRemarkComments = Boolean.FALSE;
    private static final String EXAMPLE_SUFFIX="Example";
    private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME="io.swagger.annotations.ApiModelProperty";

    /**
     * 功能说明: 设置用户配置的参数
     * 
     * @Description 设置用户配置的参数
     * @Author chendq
     * @Date 2020/5/20 14:55 
     * @Param [properties]
     **/
    @Override
    public void addConfigurationProperties(Properties properties) {
        super.addConfigurationProperties(properties);
        this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
    }

    /**
     * 功能说明: 给字段添加注释
     *
     * @Description 给字段添加注释
     * @Author chendq
     * @Date 2020/5/20 14:57
     * @Param [field, introspectedTable, introspectedColumn]
     **/
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable,
                                IntrospectedColumn introspectedColumn) {
        String remarks = introspectedColumn.getRemarks();
        //根据参数和备注信息判断是否添加备注信息
        if(addRemarkComments && StringUtility.stringHasValue(remarks)){
            //数据库中特殊字符需要转义
            if(remarks.contains("\"")){
                remarks = remarks.replace("\"","'");
            }
            //给model的字段添加swagger注解
            field.addJavaDocLine("@ApiModelProperty(value = \""+remarks+"\")");
        }
    }

    /**
     * 功能说明: 给model的字段添加注释
     *
     * @Description 给model的字段添加注释
     * @Author chendq
     * @Date 2020/5/20 14:59
     * @Param [field, remarks]
     **/
    private void addFieldJavaDoc(Field field, String remarks) {
        //文档注释开始
        field.addJavaDocLine("/**");
        //获取数据库字段的备注信息
        String[] remarkLines = remarks.split(System.getProperty("line.separator"));
        for(String remarkLine:remarkLines){
            field.addJavaDocLine(" * "+remarkLine);
        }
        addJavadocTag(field, false);
        field.addJavaDocLine(" */");
    }

    /**
     * 功能说明: 添加Java文件注释
     * 
     * @Description 添加Java文件注释
     * @Author chendq
     * @Date 2020/5/20 14:59 
     * @Param [compilationUnit]
     **/
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        super.addJavaFileComment(compilationUnit);
        //只在model中添加swagger注解类的导入
        if(!compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)){
            compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
        }
    }

}
