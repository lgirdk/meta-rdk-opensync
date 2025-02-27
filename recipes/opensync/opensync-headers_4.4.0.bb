SUMMARY = "OpenSync schema headers"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=df3f42ef5870da613e959ac4ecaa1cb8"

inherit python3native

SRCREV_core ?= "${AUTOREV}"

OPENSYNC_DEFAULT_PROTOCOL ?= "https"
OPENSYNC_DEFAULT_BRANCH ?= "osync_${PV}"

OPENSYNC_CORE_REPO_PATH ?= "git://git@github.com/plume-design/opensync.git"
OPENSYNC_CORE_REPO_PROTOCOL ?= "${OPENSYNC_DEFAULT_PROTOCOL}"
OPENSYNC_CORE_BRANCH ?= "${OPENSYNC_DEFAULT_BRANCH}"

OPENSYNC_CORE_URI ?= "${OPENSYNC_CORE_REPO_PATH};protocol=${OPENSYNC_CORE_REPO_PROTOCOL};branch=${OPENSYNC_CORE_BRANCH};name=core;destsuffix=git/core"

SRC_URI = "${OPENSYNC_CORE_URI}"

S = "${WORKDIR}/git/core"

do_configure[noexec] = "1"

do_compile() {
	${S}/src/lib/schema/schema.py ${S}/interfaces/opensync.ovsschema > ${B}/schema_gen.h
}

do_install() {
	install -d ${D}${includedir}/opensync_headers
	install -m 0644 ${B}/schema_gen.h ${D}${includedir}/opensync_headers/
}
