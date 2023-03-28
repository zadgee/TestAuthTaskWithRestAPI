package retrofit

import javax.inject.Qualifier

@Qualifier
@Target(AnnotationTarget.VALUE_PARAMETER,AnnotationTarget.CLASS,AnnotationTarget.FUNCTION)
annotation class Route

@Qualifier
@Target(AnnotationTarget.VALUE_PARAMETER,AnnotationTarget.CLASS,AnnotationTarget.FUNCTION)
annotation class CheckVersion

@Qualifier
@Target(AnnotationTarget.VALUE_PARAMETER,AnnotationTarget.CLASS,AnnotationTarget.FUNCTION)
annotation class AuthAPI

@Qualifier
@Target(AnnotationTarget.VALUE_PARAMETER,AnnotationTarget.CLASS,AnnotationTarget.FUNCTION)
annotation class BrandsAPI

@Qualifier
@Target(AnnotationTarget.VALUE_PARAMETER,AnnotationTarget.CLASS,AnnotationTarget.FUNCTION)
annotation class USERAPI


@Qualifier
@Target(AnnotationTarget.VALUE_PARAMETER,AnnotationTarget.CLASS,AnnotationTarget.FUNCTION)
annotation class MenuAPIAnnotation
