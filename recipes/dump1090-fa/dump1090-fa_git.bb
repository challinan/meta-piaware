SUMMARY = "ADS-B Mode S Decoder"
HOMEPAGE = "http://www.cherokee-project.com/"
SECTION = "network"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=751419260aa954499f7abaabaa882bbe"

DEPENDS = "ncurses rtl-sdr"

SRCREV = "cdba7566fde1ab45186f2dc4ea53e0594de484b1"
SRC_URI = "git://github.com/flightaware/dump1090"

inherit pkgconfig

S = "${WORKDIR}/git"
# B = "${WORKDIR}/git"

do_compile_prepend() {
    echo "Doing pkg-config"
    which pkg-config
    echo "Printing PKG_CONFIG_PATH:"
    echo $PKG_CONFIG_PATH
    pkg-config --cflags librtlsdr
}

do_compile() {
    oe_runmake BLADERF=no
}

do_install_append () {
}

# See meta-webserver/recipes-httpd/cherokee/cherokee_git.bb for
# example of creating a service file
