package com.java.components.lang.annotation;

import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.RoundEnvironment;
import javax.annotation.processing.SupportedAnnotationTypes;
import javax.annotation.processing.SupportedSourceVersion;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;

import java.io.IOException;
import java.util.Set;


@SupportedAnnotationTypes("Unused")
@SupportedSourceVersion(SourceVersion.RELEASE_8)
public class UnusedProcessor extends AbstractProcessor {

    @Override
    public boolean process(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
        for (Element element : roundEnv.getElementsAnnotatedWith(Unused.class)) {
            if (element.getKind() == ElementKind.CLASS || element.getKind() == ElementKind.METHOD || element.getKind() == ElementKind.FIELD) {
                // addSuppressWarnings(element);
                return false;
            }
        }
        return true;
    }
}
/*
    private void addSuppressWarnings(Element element) {
        Trees trees = Trees.instance(processingEnv);
        TreePath path = trees.getPath(element);
        Tree tree = path.getLeaf();
        JCTree jcTree = (JCTree) tree;

        JCTree.JCAnnotation SuppressWarningsAnnotation = processingEnv.getElementUtils().getElementValuesWithDefaults(
            processingEnv.getElementUtils().getTypeElement(SuppressWarnings.class.getCanonicalName())
        ).keySet().iterator().next();

        jcTree.mods.annotations = jcTree.mods.annotations.append(SuppressWarningsAnnotation)
    }
*/