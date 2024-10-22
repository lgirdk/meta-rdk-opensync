# The following change is required for RDK 2019q2:
BBCLASSEXTEND = "native nativesdk"
RDEPENDS:${PN}:class-native = " "
PACKAGES:class-nativesdk = "${PN} ${PN}-dbg ${PN}-dev ${PN}-doc ${PN}-staticdev ${PN}-switch"
RDEPENDS:${PN}:class-nativesdk = " "
RDEPENDS:${PN}-switch:class-nativesdk = " "
